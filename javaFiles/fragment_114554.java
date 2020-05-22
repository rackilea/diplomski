class Node
{
public:
    Node();
    Node(Node* parent, std::vector<Instance>& instances);
    Node* parent;
    std::vector<Node*> children;
    ....
};

Node::Node(Node* parent, std::vector<Instance>& instances) {

    this->parent = parent;
    this->children= std::vector<Node*>(Instance::FTSVALUERANGE);
    ...
}