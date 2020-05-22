/**
 * Outputs the selectors and properties for the CheckBox component.
 *
 * @param {string} $primary-stylename (v-checkbox) - the primary style name for the selectors
 * @param {bool} $include-additional-styles - should the mixin output all the different style variations of the component
 *
 * @group checkbox
 */
@mixin valo-checkbox ($primary-stylename: v-checkbox, $include-additional-styles: contains($v-included-additional-styles, checkbox)) {

  .#{$primary-stylename} {
    @include valo-checkbox-style;
  }


  @if $include-additional-styles {
    .#{$primary-stylename}-small {
      @include valo-checkbox-style($unit-size: $v-unit-size--small);
      font-size: $v-font-size--small;
    }

    .#{$primary-stylename}-large {
      @include valo-checkbox-style($unit-size: $v-unit-size--large);
      font-size: $v-font-size--large;
    }
  }
}