public void saveSimpleToDoByBlockId(String text, long blockId) {
    ToDoBlock block = entityManager.getReference(ToDoBlock.class, blockId);
    ToDo toDo = new ToDo(text, block);
    block.addToDo(toDo);
    entityManager.persist(toDo); // <----- persist ToDo too
    entityManager.persist(block);
}