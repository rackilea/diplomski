struct context; // only used for pointers

void init_context(struct context **ctx) { *ctx=malloc(1); printf("Init: %p\n", *ctx); }
void release_context(struct context *ctx) { printf("Delete: %p\n", ctx); free(ctx); }

void foo(struct context *ctx) { printf("foo: %p\n", ctx); }