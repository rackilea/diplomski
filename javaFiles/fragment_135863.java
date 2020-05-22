message Message
{
    extensions 100 to max;

    required uint64 A = 1;
}

message Event
{
    extend Message { 
        required Event ext = 101; 
        optional string name = 102;
    }

    extensions 100 to max;

    required uint64 B = 1;

}