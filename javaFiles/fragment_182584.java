class Client {
    void foo() {
         LAddClass lAddClass = new LAddClass();
         LStore lStore = new LStore();
         lStore.setLAddClass(lAddClass);
         lAddClass.setLStore(lStore);
         //...
    }
}