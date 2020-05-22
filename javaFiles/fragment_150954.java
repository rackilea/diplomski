GET documents/_search
{
    "query": {
        "match_phrase" : {
            "filename" : "Accessories_v1_de-DE.pdf"
        }
    }
}