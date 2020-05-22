$.ajax({
        url:'/jsonasclass/',
        type: 'GET',
        data: {
              id:1,
              userID:1.1, 
              login:'sample-login',
              firstName:'sample-first-name'
            },
        success: _callBack,
        error: _errorCallback
    });