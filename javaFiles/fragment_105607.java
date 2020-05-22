{
  "done": boolean,

  // Union field result can be only one of the following:
  "error": {
    object(Status)
  },
  "response": object(ExecutionResponse)
  ,
  // End of list of possible types for union field result.
}