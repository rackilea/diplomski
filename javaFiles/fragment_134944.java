package main

import (
    "fmt"
    "unsafe"
)

func main() {
    unsigned := make([]uint8, 0)
    unsigned = append(unsigned, 128)
    unsigned = append(unsigned, 255)

    signed := *(*[]int8)(unsafe.Pointer(&unsigned))
    fmt.Printf("%d : %d\n", signed[0], unsigned[0])
    fmt.Printf("%d : %d\n", signed[1], unsigned[1])
}
// -128 : 128
// -1 : 255