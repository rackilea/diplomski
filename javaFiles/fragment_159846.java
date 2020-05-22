template<class K, class T>
static std::vector<K*> toArray(ITemplateCommand<T,K> *command, std::list<T>& templates) {
    std::vector<K*> vec;
    vec.reserve(templates.size());
    for (T& tmpl : templates) {
        vec.push_back(command->buildTemplate(tmpl));
    }
    return vec;
}