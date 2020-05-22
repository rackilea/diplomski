attribute vec2 clientTexCoord;
  varying vec2 texCoord;  

  main(){
        ... // other code
        texCoord = clientTexCoord;
        ... // other code
  }