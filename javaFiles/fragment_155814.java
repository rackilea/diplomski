JNIEXPORT void JNICALL Java_cfd_optimisation_Cholesky_solve_1eigenLDLTx(JNIEnv *env, jclass obj, jintArray arrri, jintArray arrci, jdoubleArray arrv, jdoubleArray arrx, jdoubleArray arry, jint jn, jint jnnz) {
    int n = jn;
    int *ri = (int*)env->GetPrimitiveArrayCritical(arrri, 0);
    int *ci = (int*)env->GetPrimitiveArrayCritical(arrci, 0);
    double *v = (double*)env->GetPrimitiveArrayCritical(arrv, 0);
    int nnz = jnnz;

    double *x = (double*)env->GetPrimitiveArrayCritical(arrx, 0);
    double *y = (double*)env->GetPrimitiveArrayCritical(arry, 0);

    Eigen::SparseMatrix<double> A = colt2eigen(ri, ci, v, nnz, n);
    //Eigen::MappedSparseMatrix<double> A(n, n, nnz, ri, ci, v);

    Eigen::VectorXd a(n), b(n);
    for (int i = 0; i < n; i++) a(i) = x[i];
    //a = Eigen::Map<Eigen::VectorXd>(x, n).cast<double>(); 
    Eigen::SimplicialCholesky<Eigen::SparseMatrix<double> > solver;
    solver.setMode(Eigen::SimplicialCholeskyLDLT);
    b = solver.compute(A).solve(a);
    for (int i = 0; i < n; i++) y[i] = b(i);
    env->ReleasePrimitiveArrayCritical(arrri, ri, 0);
    env->ReleasePrimitiveArrayCritical(arrci, ci, 0);
    env->ReleasePrimitiveArrayCritical(arrv, v, 0);
    env->ReleasePrimitiveArrayCritical(arrx, x, 0);
    env->ReleasePrimitiveArrayCritical(arry, y, 0);
}