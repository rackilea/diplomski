func Difference(slice1 []string, slice2 []string) []string {
    // Create proper "set" (Maps have unordered pairs and the keys are unique;
    // lookup to check whether value is present is O(1), similar to other
    // implementations)
    m := make(map[string]struct{}, len(slice1))
    for _, el := range slice1 {
        m[el] = struct{}{}
    }

    // Remove values from slice1 present in slice2
    for _, el := range slice2 {
        delete(m, el)
    }

    // Note that res will be non-deterministic: the order of iteration over maps
    // is made random on purpose by Go itself
    res := make([]string, 0, len(m))
    for k := range m {
        res = append(res, k)
    }
    return res
}