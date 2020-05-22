/**
 * This interface represent the operation of a radix tree. A radix tree,
 * Patricia trie/tree, or crit bit tree is a specialized set data structure
 * based on the trie that is used to store a set of strings. In contrast with a
 * regular trie, the edges of a Patricia trie are labelled with sequences of
 * characters rather than with single characters. These can be strings of
 * characters, bit strings such as integers or IP addresses, or generally
 * arbitrary sequences of objects in lexicographical order. Sometimes the names
 * radix tree and crit bit tree are only applied to trees storing integers and
 * Patricia trie is retained for more general inputs, but the structure works
 * the same way in all cases.
 * 
 * @author Tahseen Ur Rehman 
 * email: tahseen.ur.rehman {at.spam.me.not} gmail.com
 */
public interface RadixTree<T> {
    /**
     * Insert a new string key and its value to the tree.
     * 
     * @param key
     *            The string key of the object
     * @param value
     *            The value that need to be stored corresponding to the given
     *            key.
     * @throws DuplicateKeyException
     */
    public void insert(String key, T value) throws DuplicateKeyException;