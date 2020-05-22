//receive UDP packet
                    int port = (int)float.Parse(Variables.port_key);
                    UdpCient UDP_packet = new UdpClient(port);
                    UDP_packet.EnableBroadcast = true;
                    IPEndPoint RemoteIpEndPoint = new IPEndPoint(IPAddress.Any, 0);
                    IPAddress from_addr = null;
                    Boolean gogo = false;
                    while (!gogo)
                    {
                        Byte[] receiveBytes = UDP_packet.Receive(ref RemoteIpEndPoint);
                        string returnData = Encoding.UTF8.GetString(receiveBytes);
                        if (returnData.ToString() == "83hcX1")
                        {
                            gogo = true;
                        }
                        from_addr = RemoteIpEndPoint.Address;
                    }
                    //send UDP packet
                    IPEndPoint ipEndPoint = new IPEndPoint(from_addr, port);
                    Byte[] sendBytes = Encoding.UTF8.GetBytes("94dbF5");
                    UDP_packet.Send(sendBytes, sendBytes.Length, ipEndPoint);
                    UDP_packet.Close();