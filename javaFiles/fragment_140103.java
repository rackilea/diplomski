package main

import (
    "bufio"
    "encoding/json"
    "fmt"
    "net"
    "os"
    "strings"
)

// Person struct.
type Person struct {
    Name string
    Age  int
}

func main() {
    reader := bufio.NewReader(os.Stdin)

    for {
        func() {
            // Dial the Java Server.
            tcpAddr, err := net.ResolveTCPAddr("tcp", "localhost:9000")
            if err != nil {
                fmt.Println(err)
                return
            }

            conn, err := net.DialTCP("tcp", nil, tcpAddr)
            if err != nil {
                fmt.Println(err)
                return
            }

            defer conn.Close()

            fmt.Print("Enter Name: ")
            strName, err := reader.ReadString('\n')
            strName = strings.TrimSpace(strName)

            var person Person
            person.Name = strName
            person.Age = 18

            jsonBytes, err := json.Marshal(person)
            if err != nil {
                fmt.Println(err)
                return
            }

            // Write our message to the connection.
            _, err = conn.Write(jsonBytes)
            if err != nil {
                fmt.Println(err)
                return
            }

            // Tell the server that we're done writing.
            err = conn.CloseWrite()
            if err != nil {
                fmt.Println(err)
                return
            }

            // Read Message From Server code goes here.

            fmt.Println("Sent: " + string(jsonBytes))
        }()
    }
}