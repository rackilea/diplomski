$resource('/user/:userId/card/:cardId', {userId:123, cardId:'@id'}, {
  charge: {method:'POST', params:{charge:true}, headers = {
        'x-session-token': function () {
          return sessionService.getToken()
        }}
 });