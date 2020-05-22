@Transactional
public void doSomeThing(){ // calling this method targets a proxy

    doSomeThingElse(); // this method targets the actual class, not the PROXY,
                       // so the transactional annotation has no effect
}

@Transactional
public void doSomeThingElse(){
}