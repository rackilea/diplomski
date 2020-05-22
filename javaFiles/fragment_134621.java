import javax.media.jai.*;
...

def f = request.getFile('myFile')
    def okContentTypes = ['image/png', 'image/jpeg', 'image/jpg', 'image/gif']

if (!okContentTypes.contains(f.getContentType())) { 
    // TODO Tell user: "Image type must be one of: ${okContentTypes}"
}

else {
    def destination = "D:\\someFolder\\image.jpg";
    byte[] source = f.bytes;
    SeekableStream inputStream = new ByteArraySeekableStream(source);
    RenderedOp image = JAI.create("stream", inputStream)
    JAI.create("filestore",image,destination,"JPEG"); // Destination directory must exist (D:\someFolder\)
}