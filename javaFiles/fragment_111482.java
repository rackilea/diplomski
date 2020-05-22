window.WebSocket = function(url)
         {
               console.log('####################creating new WebScoketInstance JS ' + url);

               var p = {
                     url: null
               };
               p.url = url;

               var ws = factoryJ.getInstance(p.url);

               var obj = {
                     send: function(data)
                     {
                           console.log('---  send: function(data)-----  ws.send1(data);------');
                           ws.send1(data);
                     },
              //.......
              //.......

               }
               return obj;


         };