/**
 * Tells if the token looks like a short option.
 *
 * @param token
 */
private boolean isShortOption(String token)
{
  // short options (-S, -SV, -S=V, -SV1=V2, -S1S2)
  // extended to handle short options of more than one character
  if (token.startsWith("-") && token.length() >= 2)
  {
    return options.hasShortOption(token.substring(1, 2)) ||
           options.hasShortOption(extractShortOption(token));
  }
  return false;
}

/**
 * Extract option from token.  Assume the token starts with '-'.
 */
private String extractShortOption(String token)
{
    int index = token.indexOf('=');
    return (index == -1) ? token.substring(1) : token.substring(1, index);
}