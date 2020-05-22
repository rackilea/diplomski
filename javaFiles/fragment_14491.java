<dom-module id="my-grid-theme" theme-for="vaadin-grid">
  <template>
    <style>
      [part~="cell"] {
        min-height: 0;
      }

      [part~="cell"] ::slotted(vaadin-grid-cell-content) {
        padding: 0;
      }
    </style>
  </template>
</dom-module>

<custom-style>
  <style>  
    .my-grid-cell {
      min-height: calc(var(--lumo-size-m) - 2 * var(--lumo-space-xs));
      padding: var(--lumo-space-xs) var(--lumo-space-m);
    }
  </style>
</custom-style>