@Controller
public class LookingGlassController {

    private final static String BGP_URL = "http://80.241.0.85/api/protocols/bgp";
    private final static String BGP_DETAILS_URL = "http://80.241.0.85/api/protocol/";
    private final static String TABLE_URL = "http://80.241.0.85/api/routes/table/";
    private final static String ROUT_URL = "http://80.241.0.85/api/route/";

    /**
     *
     * @param lang
     * @return
     */
    @RequestMapping("/{lang:ru|kk|en}/lookingglass/bgp")
    public ModelAndView bgp(@PathVariable String lang) {

        List<BGPData> bgpDateList = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(IOUtils.toString(new URL(BGP_URL), Charset.forName("UTF-8")));

            JSONObject protocols = json.getJSONObject("protocols");
            Map<String, Object> prots = protocols.toMap();
            for (String prot_name : prots.keySet()) {
                JSONObject prot = protocols.getJSONObject(prot_name);
                String protocol = prot.getString("protocol");
                String neighborAddress = prot.getString("neighbor_address");
                String description = prot.getString("description");
                Integer asn = prot.getInt("neighbor_as");
                String tableName = prot.getString("table");
                String status = prot.getString("bgp_state");

                JSONObject routesAsJSONObject = getRoutesAsJSONObject(prot);
                Integer routeImport = routesAsJSONObject.getInt("imported");
                Integer routeExport = routesAsJSONObject.getInt("exported");

                Integer importLimit = prot.getInt("import_limit");

                String tableLink = "/" + lang + "/lookingglass/table/" + tableName;

                String protocolDetailLink = "/" + lang + "/lookingglass/bgpdetails/" + protocol;

                BGPData bgpData = new BGPData();
                bgpData.setProtocol(protocol);
                bgpData.setProtocolDetailLink(protocolDetailLink);
                bgpData.setNaighbord(neighborAddress);
                bgpData.setDescription(description);
                bgpData.setAsn(asn);
                bgpData.setTableName(tableName);
                bgpData.setStatus(status);
                bgpData.setRouteImport(routeImport);
                bgpData.setRouteExport(routeExport);
                bgpData.setImportLimit(importLimit);
                bgpData.setTableLink(tableLink);
                bgpDateList.add(bgpData);
            }

        } catch (IOException | JSONException ex) {

        }

        Map<String, Object> outMap = new HashMap();
        outMap.put("lang", lang);
        outMap.put("bgpDataList", bgpDateList);
        outMap.put("lgSearchData", new LgSearchData());

        return new ModelAndView("/site/lookingglass/bgp", outMap);
    }


    /**
     *
     * @param lang
     * @param protocol
     * @return
     */
    @RequestMapping("/{lang:ru|kk|en}/lookingglass/bgpdetails/{protocol}")
    public ModelAndView bgp_details(@PathVariable String lang, @PathVariable String protocol) {

        BGPDetailData bgpDetalisData = new BGPDetailData();

        try {
            JSONObject json = new JSONObject(IOUtils.toString(new URL(BGP_DETAILS_URL + protocol), Charset.forName("UTF-8")));

            JSONObject protocolJs = json.getJSONObject("protocol");

            String bird_protocol = protocolJs.getString("bird_protocol");
            String state = protocolJs.getString("state");
            String state_changed = protocolJs.getString("state_changed");
            String connection = protocolJs.getString("connection");

            String description = protocolJs.getString("description");
            Integer preference = protocolJs.getInt("preference");
            String input_filter = protocolJs.getString("input_filter");
            String output_filter = protocolJs.getString("output_filter");
            Integer import_limit = protocolJs.getInt("import_limit");
            String limit_action = protocolJs.getString("limit_action");

            JSONObject routesAsJSONObject = getRoutesAsJSONObject(protocolJs);
            Integer routes_imported = routesAsJSONObject.getInt("imported");
            Integer routes_exported = routesAsJSONObject.getInt("exported");
            Integer routes_preferred = routesAsJSONObject.getInt("preferred");

            JSONObject jsO = protocolJs.getJSONObject("route_changes").getJSONObject("import_updates");
            String route_change_import_updates = getRouteChange(jsO);
            jsO = protocolJs.getJSONObject("route_changes").getJSONObject("import_withdraws");
            String route_change_import_withdraws = getRouteChange(jsO);
            jsO = protocolJs.getJSONObject("route_changes").getJSONObject("export_updates");
            String route_change_export_updates = getRouteChange(jsO);
            jsO = protocolJs.getJSONObject("route_changes").getJSONObject("export_withdraws");
            String route_change_export_withdraws = getRouteChange(jsO);

            String bgp_state = protocolJs.getString("bgp_state");
            String neighbor_address = protocolJs.getString("neighbor_address");
            Integer neighbor_as = protocolJs.getInt("neighbor_as");
            String neighbor_id = "";
            try {
                neighbor_id = protocolJs.getString("neighbor_id");
            } catch (JSONException ex) {
            }

            String neighbor_capabilities = "";
            try {
                JSONArray ar = protocolJs.getJSONArray("neighbor_capabilities");
                for (Object aspo : ar) {
                    neighbor_capabilities += (String) aspo + " ";
                }
            } catch (JSONException ex) {
                neighbor_capabilities = "n/a";
            }

            String session = "";
            try {
                JSONArray ar = protocolJs.getJSONArray("bgp_session");
                for (Object aspo : ar) {
                    session += (String) aspo + " ";
                }
            } catch (JSONException ex) {
                session = "n/a";
            }

            String source_address = "";
            try {
                source_address = protocolJs.getString("source_address");
            } catch (JSONException ex) {
                session = "n/a";
            }
            Integer hold_timer = null;
            try {
                hold_timer = protocolJs.getInt("hold_timer");
            } catch (JSONException ex) {
                session = "n/a";
            }
            Integer route_limit_at = null;
            try {
                route_limit_at = protocolJs.getInt("route_limit_at");
            } catch (JSONException ex) {
                session = "n/a";
            }
            Integer keepalive = null;
            try {
                keepalive = protocolJs.getInt("keepalive");
            } catch (JSONException ex) {
                session = "n/a";
            }

            bgpDetalisData.setProtocol(protocol);
            bgpDetalisData.setBird_protocol(bird_protocol);
            bgpDetalisData.setState(state);
            bgpDetalisData.setState_changed(state_changed);
            bgpDetalisData.setConnection(connection);

            bgpDetalisData.setDescription(description);
            bgpDetalisData.setPreference(preference);
            bgpDetalisData.setInput_filter(input_filter);
            bgpDetalisData.setOutput_filter(output_filter);
            bgpDetalisData.setImport_limit(import_limit);
            bgpDetalisData.setLimit_action(limit_action);

            bgpDetalisData.setRoutes_imported(routes_imported);
            bgpDetalisData.setRoutes_exported(routes_exported);
            bgpDetalisData.setRoutes_preferred(routes_preferred);

            bgpDetalisData.setRoute_change_import_updates(route_change_import_updates);
            bgpDetalisData.setRoute_change_import_withdraws(route_change_import_withdraws);
            bgpDetalisData.setRoute_change_export_updates(route_change_export_updates);
            bgpDetalisData.setRoute_change_export_withdraws(route_change_export_withdraws);

            bgpDetalisData.setBgp_state(bgp_state);
            bgpDetalisData.setNeighbor_address(neighbor_address);
            bgpDetalisData.setNeighbor_as(neighbor_as);
            bgpDetalisData.setNeighbor_id(neighbor_id);

            bgpDetalisData.setNeighbor_capabilities(neighbor_capabilities);
            bgpDetalisData.setBgp_session(session);

            bgpDetalisData.setSource_address(source_address);
            bgpDetalisData.setHold_timer(hold_timer);
            bgpDetalisData.setRoute_limit_at(route_limit_at);
            bgpDetalisData.setKeepalive(keepalive);

        } catch (IOException | JSONException ex) {
        }

        Map<String, Object> outMap = new HashMap();
        outMap.put("lang", lang);
        outMap.put("bgpDetails", bgpDetalisData);

        return new ModelAndView("/site/lookingglass/bgp_details", outMap);
    }

    /**
     *
     * @param jsO
     * @return
     */
    private String getRouteChange(JSONObject jsO) {

        String out = "";

        try {
            Integer received = jsO.getInt("received");
            out += "recived: " + received + ", ";
        } catch (JSONException ex) {
        }

        try {
            Integer rejected = jsO.getInt("rejected");
            out += "rejected: " + rejected + ", ";
        } catch (JSONException ex) {
        }

        try {
            Integer filtered = jsO.getInt("filtered");
            out += "filtered: " + filtered + ", ";
        } catch (JSONException ex) {
        }

        try {
            Integer ignored = jsO.getInt("ignored");
            out += "ignored: " + ignored + ", ";
        } catch (JSONException ex) {
        }

        try {
            Integer accepted = jsO.getInt("accepted");
            out += "accepted: " + accepted + ", ";
        } catch (JSONException ex) {
        }

        return out.substring(0, out.length() - 2);
    }

    /**
     *
     * @param lang
     * @param name
     * @return
     */
    @RequestMapping("/{lang:ru|kk|en}/lookingglass/table/{name}")
    public ModelAndView table(@PathVariable String lang, @PathVariable String name) {

        List<TableData> tableDateList = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(IOUtils.toString(new URL(TABLE_URL + name), Charset.forName("UTF-8")));

            JSONArray routes = json.getJSONArray("routes");
            routes.forEach(action -> {
                JSONObject rout = (JSONObject) action;

                String network = rout.getString("network");
                String gateway = rout.getString("gateway");
                Integer metric = rout.getInt("metric");
                Boolean primary = rout.getBoolean("primary");
                Integer communities = 0;

                String aspath = "";

                JSONArray ar = rout.getJSONObject("bgp").getJSONArray("as_path");
                for (Object aspo : ar) {
                    aspath += (String) aspo + " ";
                }

                try {
                    JSONArray ar1 = rout.getJSONObject("bgp").getJSONArray("communities");
                    communities = ar1.length();
                } catch (JSONException ex) {
                }

                String networkLink = "/" + lang + "/lookingglass/route/" + network;
                TableData tableData = new TableData();
                tableData.setNetwork(network);
                tableData.setNetworkLink(networkLink);
                tableData.setGateway(gateway);
                tableData.setMetric(metric);
                tableData.setCommunities(communities);
                tableData.setAspath(aspath);
                tableData.setPrimary(primary);

                tableDateList.add(tableData);
            });

        } catch (IOException ex) {
            name = "UNKNOWN";
        } catch (JSONException ex) {
        }

        Map<String, Object> outMap = new HashMap();
        outMap.put("tableDataList", tableDateList);
        outMap.put("tableName", name);

        return new ModelAndView("/site/lookingglass/table", outMap);
    }

    /**
     *
     * @param lang
     * @param ip
     * @param mask
     * @return
     */
    @RequestMapping("/{lang:ru|kk|en}/lookingglass/route/{ip}/{mask}")
    public ModelAndView rout(@PathVariable String lang, @PathVariable String ip, @PathVariable String mask) {

        String net;
        List<TableData> tableDateList = new ArrayList<>();
        try {

            net = ip + "/" + mask;

            String url = ROUT_URL + URLEncoder.encode(net, "UTF-8");

            JSONObject json = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));

            JSONArray routes = json.getJSONArray("routes");
            routes.forEach(action -> {
                JSONObject rout = (JSONObject) action;

                String network = rout.getString("network");
                String gateway = rout.getString("gateway");
                Integer metric = rout.getInt("metric");
                Boolean primary = rout.getBoolean("primary");
                String inter_face = rout.getString("interface");
                String age = rout.getString("age");
                String from_protocol = rout.getString("from_protocol");

                String origin = rout.getJSONObject("bgp").getString("origin");
                Integer med = null;
                try {
                    med = rout.getJSONObject("bgp").getInt("med");
                } catch (JSONException ex) {
                }
                String localPref = rout.getJSONObject("bgp").getString("local_pref");
                String aspath = "";
                JSONArray ar = rout.getJSONObject("bgp").getJSONArray("as_path");
                for (Object aspo : ar) {
                    aspath += (String) aspo + " ";
                }

                String type = "";
                JSONArray ar1 = rout.getJSONArray("type");
                for (Object t : ar1) {
                    type += (String) t + " ";
                }

                String communitiesList = "";
                try {
                    JSONArray ar2 = rout.getJSONObject("bgp").getJSONArray("communities");
                    for (Object o : ar2) {
                        JSONArray ar3 = (JSONArray) o;
                        communitiesList += "(";
                        int index = 0;
                        for (Object o1 : ar3) {
                            if (index > 0) {
                                communitiesList += ", ";
                            }
                            communitiesList += (Integer) o1;
                            index++;
                        }
                        communitiesList += ") ";
                    }
                } catch (JSONException ex) {
                }
                if (communitiesList.isEmpty()) {
                    communitiesList = null;
                }

                TableData tableData = new TableData();
                tableData.setNetwork(network);
                tableData.setGateway(gateway);
                tableData.setMetric(metric);
                tableData.setAspath(aspath);
                tableData.setInter_face(inter_face);
                tableData.setAge(age);
                tableData.setFromProtocol(from_protocol);
                tableData.setType(type);
                tableData.setOrigin(origin);
                tableData.setLocalPref(localPref);
                tableData.setCommunitiesList(communitiesList);
                tableData.setMed(med);
                tableData.setPrimary(primary);

                tableDateList.add(tableData);
            });

        } catch (IOException | JSONException ex) {
            net = "UNKNOWN";
        }

        Map<String, Object> outMap = new HashMap();
        outMap.put("tableDataList", tableDateList);
        outMap.put("net", net);

        return new ModelAndView("/site/lookingglass/route", outMap);
    }

    /**
     *
     * @param lang
     * @param lgSearchData
     * @param result
     * @param model
     * @return
     */
    @RequestMapping("/{lang:ru|kk|en}/lookingglass/search")
    public ModelAndView search(@PathVariable String lang,
                               @Valid @ModelAttribute("lgSearchData") LgSearchData lgSearchData,
                               BindingResult result,
                               ModelMap model) {

        String ip = lgSearchData.getIp();

        if (ip == null || ip.isEmpty()) {
            return new ModelAndView("redirect:/" + lang + "/lookingglass/bgp");
        }

        try {

            JSONObject json = new JSONObject(IOUtils.toString(new URL(ROUT_URL + URLEncoder.encode(ip, "UTF-8")), Charset.forName("UTF-8")));

            JSONArray routes = json.getJSONArray("routes");
            JSONObject rout = routes.getJSONObject(0);
            if (rout != null) {
                String network = rout.getString("network");
                return new ModelAndView("redirect:/" + lang + "/lookingglass/route/" + network);
            }
        } catch (IOException | JSONException ex) {

        }

        return new ModelAndView("/site/lookingglass/bgp");
    }

    private JSONObject getRoutesAsJSONObject(JSONObject jsonObject) {
        if (jsonObject.has("routes")) {
            try {
                return jsonObject.getJSONObject("routes");
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        }
        JSONObject routesJSON = new JSONObject();
        try {
            routesJSON.put("imported", 0);
            routesJSON.put("exported", 0);
            routesJSON.put("preferred", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return routesJSON;
    }
}