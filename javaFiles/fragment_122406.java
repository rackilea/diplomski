$router->get('/demo',function(){
         $heroes = [
                   ['name' => 'mahesh'],  //this associative array represent your Android `Hero` mapping class
                   ['name' => 'vishal'],
                  ]
        return response()->json($heroes);
});