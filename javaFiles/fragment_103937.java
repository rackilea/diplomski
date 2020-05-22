public ResponseEntity someEndpoint(final EnumActionValues aAction) {

  if ((aAction != null) && !EnumActionValues.getManuallyAllowedActions().contains(aAction)) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
  }

  ...
}