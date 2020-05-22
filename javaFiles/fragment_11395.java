#{if session.username }
    <!-- You can show users' profile -->
#{/if}
#{else}
    <!-- Show login form now. You can create a login template-tag form and call it here. -->
#{/else}