final Res res = acquire();
try {
    use(res);
} finally {
    res.release();
}