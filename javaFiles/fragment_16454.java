fetch('https://fcm.googleapis.com/fcm/send', {
    'method': 'POST',
    'headers': {
      'Authorization': 'key=' + fromKey,
      'Content-Type': 'application/json'
    },
    'body': JSON.stringify({
      'data': notification,
      'to': toKey
    })
  }).then(function(response) {
    console.log(response);
  }).catch(function(error) {
    console.error(error);
  })
};