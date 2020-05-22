import java.util.UUID;

import me.prettyprint.cassandra.serializers.CompositeSerializer;
import me.prettyprint.cassandra.serializers.IntegerSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.serializers.UUIDSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.Composite;
import me.prettyprint.hector.api.beans.HColumn;
import me.prettyprint.hector.api.beans.AbstractComposite.ComponentEquality;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;

    // put this here to make it compile cleanly

    Keyspace keyspace = null;
    UUID userID = null;
    UUID itemID = null;
    String description = null;

            // Row key is user_id of type UUID

    Mutator<UUID> mutator = HFactory.createMutator(
            keyspace,
            UUIDSerializer.get());

        // write column for itemID.  
        // Column name is composite of itemID value and constant "item_id"
        // Row key is value of userID

    Composite itemIdColumnName = new Composite();
    itemIdColumnName.addComponent(itemID    , UUIDSerializer.get());
    itemIdColumnName.addComponent("item_id" , StringSerializer.get());
        // HFactory.createColumn takes args: column name, column value, serializer for column name, serializer for column value
    HColumn<Composite, UUID> hColumnObj_itemID = HFactory.createColumn(itemIdColumnName, userID, new CompositeSerializer(), UUIDSerializer.get());
    mutator.addInsertion(userID, "my_items", hColumnObj_itemID);

    // write column for description.  
    // Column name is composite of itemID value and constant "description"
    // Row key is value of userID

    Composite descriptionColumnName = new Composite();
    itemIdColumnName.addComponent(itemID    , UUIDSerializer.get());
    itemIdColumnName.addComponent("description" , StringSerializer.get());
    HColumn<Composite, String> hColumnObj_description = HFactory.createColumn(descriptionColumnName, description , new CompositeSerializer(), StringSerializer.get());
    mutator.addInsertion(userID, "my_items", hColumnObj_description);

    mutator.execute();