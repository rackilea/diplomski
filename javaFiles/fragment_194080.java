Vertex ver = findVertex(s);

            if (ver == null)
            {
                ver = new Vertex(s);
                this.vertices.add(ver);
            }

            ver.edgeLength = scan.nextInt();

            from.connected.add(ver);