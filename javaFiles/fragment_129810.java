@import "../reindeer/reindeer.scss";

@keyframes keyframe1 {
    from {background: red;}
    to {background: yellow;}
}
@keyframes keyframe2 {
  from {background: yellow;}
  to {background: red;}
}

@mixin app {
  @include reindeer;

  .keyframe1 {
    background: yellow;
    -webkit-animation: keyframe1 1s linear;
    -moz-animation: keyframe1 1s linear;
    -ms-animation: keyframe1 1s linear;
    animation: keyframe1 1s linear;
  }

  .keyframe2 {
    background: red;
    -webkit-animation: keyframe2 1s linear;
    -moz-animation: keyframe2 1s linear;
    -ms-animation: keyframe2 1s linear;
    animation: keyframe2 1s linear;
  }

}