char *concatenated;
const jbyte *sx;
jstring retval;

/* Get the UTF-8 characters that represent our java string */
sx = (*env)->GetStringUTFChars(env, s, NULL);

/* Concatenate the two strings. */
concatenated = malloc(strlen("asd ") + strlen(sx) + 1);
strcpy(concatenated, "asd ");
strcat(concatenated, sx);

/* Create java string from our concatenated C string */
retval = (*env)->NewStringUTF(env, concatenated);

/* Free the memory in sx */
(*env)->ReleaseStringUTFChars(env, s, sx);

/* Free the memory in concatenated */
free(concatenated);

return retval;