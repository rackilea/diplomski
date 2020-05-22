// Loaded entity instances, by EntityKey
private Map entitiesByKey;

// Loaded entity instances, by EntityUniqueKey
private Map entitiesByUniqueKey;

// Identity map of EntityEntry instances, by the entity instance
private Map entityEntries;

// Entity proxies, by EntityKey
private Map proxiesByKey;

// Snapshots of current database state for entities
// that have *not* been loaded
private Map entitySnapshotsByKey;

// Identity map of array holder ArrayHolder instances, by the array instance
private Map arrayHolders;

// Identity map of CollectionEntry instances, by the collection wrapper
private Map collectionEntries;

// Collection wrappers, by the CollectionKey
private Map collectionsByKey; //key=CollectionKey, value=PersistentCollection

// Set of EntityKeys of deleted objects
private HashSet nullifiableEntityKeys;

// properties that we have tried to load, and not found in the database
private HashSet nullAssociations;

// A list of collection wrappers that were instantiating during result set
// processing, that we will need to initialize at the end of the query
private List nonlazyCollections;

// A container for collections we load up when the owning entity is not
// yet loaded ... for now, this is purely transient!
private Map unownedCollections;

// Parent entities cache by their child for cascading
// May be empty or not contains all relation 
private Map parentsByChild;