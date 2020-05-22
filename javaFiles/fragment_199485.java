package main
import (
   "context"
   "github.com/golang/protobuf/proto"
   "github.com/rsocket/rsocket-go"
   "github.com/rsocket/rsocket-go/payload"
   "github.com/rsocket/rsocket-go/rx"
   "github.com/rsocket/rsocket-go/rx/flux"
   "rsocket-go-rpc-test/proto"
)
type TestService struct {
   totals int
pl_dwojciechowski_proto.FileService
}
var statusOK = &pl_dwojciechowski_proto.UploadStatus{
   Message: "code",
Code:    pl_dwojciechowski_proto.UploadStatusCode_Ok,
}
var statusErr = &pl_dwojciechowski_proto.UploadStatus{
   Message: "code",
Code:    pl_dwojciechowski_proto.UploadStatusCode_Failed,
}
func main() {
   addr := "tcp://127.0.0.1:8081"
ctx, cancel := context.WithCancel(context.Background())
   defer cancel()
   err := rsocket.Receive().
      Fragment(1024).
      Acceptor(func(setup payload.SetupPayload, sendingSocket rsocket.CloseableRSocket) (rsocket.RSocket, error) {
         return rsocket.NewAbstractSocket(
            rsocket.RequestChannel(func(msgs rx.Publisher) flux.Flux {
               dataReceivedChan := make(chan bool, 1)
               toChan, _ := flux.Clone(msgs).
                  DoOnError(func(e error) {
                     dataReceivedChan <- false
}).
                  DoOnComplete(func() {
                     dataReceivedChan <- true
}).
                  ToChan(ctx, 1)
               fluxResponse := flux.Create(func(ctx context.Context, s flux.Sink) {
                  gluedContent := make([]byte, 1024)
                  for c := range toChan {
                     chunk := pl_dwojciechowski_proto.Chunk{}
                     _ = chunk.XXX_Unmarshal(c.Data())
                     gluedContent = append(gluedContent, chunk.Content...)
                  }
                  if <-dataReceivedChan {
                     marshal, _ := proto.Marshal(statusOK)
                     s.Next(payload.New(marshal, nil))
                     s.Complete()
                  } else {
                     marshal, _ := proto.Marshal(statusErr)
                     s.Next(payload.New(marshal, nil))
                     s.Complete()
                  }
               })
               return fluxResponse
}),
), nil
}).
      Transport(addr).
      Serve(ctx)
   panic(err)
}