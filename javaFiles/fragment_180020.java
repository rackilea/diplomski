/**
 * Signs the constructed JWT using the specified algorithm with the specified key, producing a JWS.
 *
 * <p>This is a convenience method: the string argument is first BASE64-decoded to a byte array and this resulting
 * byte array is used to invoke {@link #signWith(SignatureAlgorithm, byte[])}.</p>
 *
 * <h4>Deprecation Notice: Deprecated as of 0.10.0, will be removed in the 1.0 release.</h4>
 *
 * <p>This method has been deprecated because the {@code key} argument for this method can be confusing: keys for
 * cryptographic operations are always binary (byte arrays), and many people were confused as to how bytes were
 * obtained from the String argument.</p>
 *
 * <p>This method always expected a String argument that was effectively the same as the result of the following
 * (pseudocode):</p>
 *
 * <p>{@code String base64EncodedSecretKey = base64Encode(secretKeyBytes);}</p>
 *
 * <p>However, a non-trivial number of JJWT users were confused by the method signature and attempted to
 * use raw password strings as the key argument - for example {@code signWith(HS256, myPassword)} - which is
 * almost always incorrect for cryptographic hashes and can produce erroneous or insecure results.</p>
 *
 * <p>See this
 * <a href="https://stackoverflow.com/questions/40252903/static-secret-as-byte-key-or-string/40274325#40274325">
 * StackOverflow answer</a> explaining why raw (non-base64-encoded) strings are almost always incorrect for
 * signature operations.</p>
 *
 * <p>To perform the correct logic with base64EncodedSecretKey strings with JJWT >= 0.10.0, you may do this:
 * <pre><code>
 * byte[] keyBytes = {@link Decoders Decoders}.{@link Decoders#BASE64 BASE64}.{@link Decoder#decode(Object) decode(base64EncodedSecretKey)};
 * Key key = {@link Keys Keys}.{@link Keys#hmacShaKeyFor(byte[]) hmacShaKeyFor(keyBytes)};
 * jwtBuilder.signWith(key); //or {@link #signWith(Key, SignatureAlgorithm)}
 * </code></pre>
 * </p>
 *
 * <p>This method will be removed in the 1.0 release.</p>
 *
 * @param alg                    the JWS algorithm to use to digitally sign the JWT, thereby producing a JWS.
 * @param base64EncodedSecretKey the BASE64-encoded algorithm-specific signing key to use to digitally sign the
 *                               JWT.
 * @return the builder for method chaining.
 * @throws InvalidKeyException if the Key is insufficient or explicitly disallowed by the JWT specification as
 *                             described by {@link SignatureAlgorithm#forSigningKey(Key)}.
 * @deprecated as of 0.10.0: use {@link #signWith(Key)} or {@link #signWith(Key, SignatureAlgorithm)} instead.  This
 * method will be removed in the 1.0 release.
 */
JwtBuilder signWith(SignatureAlgorithm alg, String base64EncodedSecretKey);