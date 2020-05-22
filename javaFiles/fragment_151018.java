function validateToken(token){
    jwt.verify(token, 'shhhhh', function(err, decoded) {
       if (err) {
        /*
            err = {
            name: 'TokenExpiredError',
            message: 'jwt expired',
            expiredAt: 1408621000
          }
        */
      }
}