class ToDoDaoImpl implements ToDoDao {
    Map<String, ToDo> toDos;
    // ...
    public Observable<List<ToDo>> readAll() {
        return Observable.fromCallable(() -> new ArrayList<>(toDos.values()));
    }
}

@Api(path = "/api/v2/read", method = "GET", produces = "application/json")
Action readAllToDos = (HttpServletRequest request, HttpServletResponse response) -> 
{
    toDoDao.readAll()
        .subscribe((List<ToDo output)  -> 
            toJsonResponse(request, response, new ResponseDto(200, output)),
                   error   -> 
            toJsonResponse(request, response, new ResponseDto(200, error))
        );
};