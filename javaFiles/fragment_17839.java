<dom-module id="my-input-theme" theme-for="vaadin-text-field">
  <template>
    <style>
      :host([theme~="bordered"]) [part="input-field"] {
        border: 3px solid hotpink;
      }
    </style>
  </template>
</dom-module>

<vaadin-text-field label="Themed" theme="bordered"></vaadin-text-field>