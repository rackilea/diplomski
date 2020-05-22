void JSfunc() {
    v8::Isolate* currentIsolate = v8::Isolate::GetCurrent();
    if(!currentIsolate) {
        currentIsolate = v8::Isolate::New();
        currentIsolate->Enter();
    }
    v8::HandleScope handle_scope(currentIsolate);
    v8::Handle<v8::ObjectTemplate> global = v8::ObjectTemplate::New();
}