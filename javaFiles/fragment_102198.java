public void sort(){
    for(int i=2;i<services.length;i++){
        int j=i-1;
        FooService key=services[i];
        while((j>-1)&& ((services[j].getName().compareTo(key.getName()))>0)){
            services[j+1]=services[j];
            j--;
        }
        services[j+1]=key;
    }
}