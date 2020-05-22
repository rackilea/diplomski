auto hashCode = [](const RVPoint3D pt)
{
    return pt.x + pt.y + pt.z;
};

std::unordered_map<RVPoint3D, int, std::function<double(RVPoint3D)>> pointMap{modelFull.getFaces().size(), hashCode};