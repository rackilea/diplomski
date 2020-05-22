[
  {
    "operation": "shift",
    "spec": {
      "*": {
        "Samples": {
          "*": {
            "*": {
              "$1": "Samples.&2[#2].tag_name",
              "*": "Samples.&2[#2].&"
            }
          }
        }
      }
    }
  },
  {
    "operation": "shift",
    "spec": {
      "Samples": {
        "*": {
          "*": "Samples[]"
        }
      }
    }
  }
]