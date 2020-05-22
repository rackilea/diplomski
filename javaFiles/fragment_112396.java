/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.ip.tcp.serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.serializer.Deserializer;
import org.springframework.util.StreamUtils;

/**
 * A deserializer that uses an elastic {@link ByteArrayOutputStream}
 * instead of a fixed buffer. Completion is indicated by the sender
 * closing the socket.
 *
 * @author Gary Russell
 * @since 5.0
 *
 */
public class ByteArrayElasticRawDeserializer implements Deserializer<byte[]> {

    @Override
    public byte[] deserialize(InputStream inputStream) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamUtils.copy(inputStream, out);
        out.close();
        return out.toByteArray();
    }

}