for(i = 0; i < obj.apis.length; i++) {
    var api = obj.apis[i];
    var path = '/rest-resource'+api.path;
    var operations = api.operations;
    this.operations(path, obj.resourcePath, operations, resourceLevelAuth, swagger);
}