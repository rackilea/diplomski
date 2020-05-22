class OuterClass{
    InnerClass dataMem1;
    InnerClass dataMem2;
}


class InnerClass{
    OuterClass objInjectedByCompiler;
    int k;
    // constructor
    InnerClass(OuterClass objectOfOuter){
        this.objInjectedByCompiler = objectOfOuter;
    }
}