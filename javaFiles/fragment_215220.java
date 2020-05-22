public void run() {
    for(int i = 0;i < list.size(); i++)
        service.deleteFromAllSchemas(i);
}

@Transactional
public void deleteFromAllSchemas(int i) {
    deleteFromSchemaOne(i);
    deleteFromSchemaTwo(i);
}