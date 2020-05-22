$v-unit-size--huge: 60px;
  $v-font-size--huge: 60px;

  // Insert your own theme rules here
  .v-checkbox-huge {
  @include valo-checkbox-style($unit-size: $v-unit-size--huge);
      font-size: $v-font-size--huge;
    }