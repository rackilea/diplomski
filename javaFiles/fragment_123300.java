/*
 * Copyright (C) 2014, Mathieu Lavigne <bludwarf@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package org.simpleframework.xml.strategy;

import static org.simpleframework.xml.strategy.Name.*;

import java.util.Map;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

/**
 * CycleStrategy for SimpleXML allowing having duplicate IDs on nodes from different types.
 * 
 * <p>Known limitations : </p>
 * 
 * <ul>
 * <li>as for Legacy CycleStrategy, new ids are generated for <b>every node</b> when calling {@link Persister#write(Object, java.io.File)}
 * </ul>
 * 
 * @author bludwarf@gmail.com
 * @since 26 juin 2014
 */
public class TypedCycleStrategy extends CycleStrategy
{
    private String mark;
    private String refer;

    public TypedCycleStrategy()
    {
        this(MARK, REFER, LABEL, LENGTH);
    }

    public TypedCycleStrategy(String mark, String refer)
    {
        this(mark, refer, LABEL, LENGTH);
    }

    public TypedCycleStrategy(String mark, String refer, String label)
    {
        this(mark, refer, label, LENGTH);
    }


    public TypedCycleStrategy(String mark, String refer, String label, String length)
    {
        super(mark, refer, label, length);
        this.mark = mark;
        this.refer = refer;
    }

    public Value read(Type type, NodeMap node, Map map)
            throws Exception
    {
        // Unique id
        makeUniqueAttribute(mark, node, type);

        // Unique ref
        makeUniqueAttribute(refer, node, type);

        return super.read(type, node, map);
    }


    /**
     * @param attribute mark OR refer
     * @param node current node
     * @param type node type
     * @return the uniqueId created
     * @throws Exception
     */
    public static String makeUniqueAttribute(String attribute, NodeMap node, Type type) throws Exception
    {
        final Node entry = node.remove(attribute);
        String uniqueId = null;

        // Attribute found ?
        if (entry != null)
        {
            // Replace it to make it unique
            final String id = entry.getValue();
            uniqueId = type.getType().getName() + "-" + id;
            node.put(attribute, uniqueId);
        }

        return uniqueId;
    }

}