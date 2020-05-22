try {
    SecurityContext ctx = SecurityContextHolder.createEmptyContext();
    SecurityContextHolder.setContext(ctx);
    ctx.setAuthentication(event.getAuthentication());
} finally {
    SecurityContextHolder.clearContext();
}