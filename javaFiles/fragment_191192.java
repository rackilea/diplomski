require.config({
    baseUrl: "js/app"
});

require (["a", "b"], function(a,  b) {
    print('modules loaded');
});