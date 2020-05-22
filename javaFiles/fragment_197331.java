function applyOptions(instance, options) {
    Object.keys(options).forEach(function(key) {
        instance[key] = options[key];
    });
    return instance;
}