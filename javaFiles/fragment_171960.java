curl -XPUT localhost:9200/your_index/your_type/1 -d '{
    "name"       : "John Smith",
    "age"        : "31",
    "checkpoints": [
        {
            "checkpoint" : "Race Start",
            "timestamp"  : "..."
        },
        {
            "checkpoint" : "Checkpoint1",
            "timestamp"  : "..."
        },
        {
            "checkpoint" : "Checkpoint2",
            "timestamp"  : "..."
        }
    ]
}'