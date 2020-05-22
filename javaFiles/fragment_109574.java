void Euler_tour(TreeNode* root, vector<int>& result){
    if (root == NULL)
        return;

    result.push_back(root->data);
    if (root->left){
        Euler_tour(root->left, result);
        result.push_back(root->data);
    }
    if (root->right){
        Euler_tour(root->right, result);
        result.push_back(root->data);
    }
}