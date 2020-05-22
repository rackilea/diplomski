@mixin mytheme1 {
  @include valo;
  // Insert your own theme rules here

  .red-border {
    // custom style added with addStyleName()
    border: 1px red solid;
  }

  .v-button {
    // global override of default v-button rule
    background-color: green;
  }
}