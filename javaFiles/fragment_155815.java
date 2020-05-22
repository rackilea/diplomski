Eigen::SparseMatrix<double> colt2eigen(int *ri, int *ci, double* v, int nnz, int n) {
    std::vector<Eigen::Triplet<double>> tripletList;
    for (int i = 0; i < nnz; i++) { 
        tripletList.push_back(Eigen::Triplet<double>(ri[i], ci[i], v[i]));  
    }
    Eigen::SparseMatrix<double> m(n, n);
    m.setFromTriplets(tripletList.begin(), tripletList.end());
    return m;
}